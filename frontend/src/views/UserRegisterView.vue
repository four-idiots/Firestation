<template>
    <div class="i">
      <form v-on:submit.prevent="submitForm" >
       <div>
        <h1>User Register</h1>
        <br/>
                <div>
                  <i class="icon-phone"></i>
                  <b>Telephone</b><br />
                  <input
                    type="tel"
                    v-model="phonenumber"
                    pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}"
                    placeholder="010-1234-5678"
                  />
                </div>
                <br/>
                <div>
                  <i class="icon-building-filled"></i>
                  <b>House Name</b><br />

                  <input
                    type="text"
                    v-model="apartname"
                    placeholder=" oo아파트"
                  />
                </div>
                <br/>
                <div>
                  <i class="icon-home"></i>
                  <b>Address (building / unit)</b><br />
                  <input
                    type="number"

                    v-model="building"
                    placeholder="(숫자)동"
                    style="width: 130px"
                  />
                  /
                  <input
                    type="number"
                    v-model="unit"
                    style="width: 130px"
                    placeholder="(숫자)호"
                  />
                </div>
                <br/>

                <div id="fires">
                  <i class="icon-handshake-o"></i>
                  <b> Fire Station</b><br />
                  <b id="info"></b>
                  <input
                    id="firestation"
                    type="button"
                    value ="누르면 자동으로 최단거리 소방서 출력"
                    name="station"
                    @click="please"
                  />
                </div>
                <br/>
                <div>
                  <input class="butt" type="submit" @click="post" value="Register" />
                </div>

      </div>

    </form>

    </div>
</template>

<script>

import axios from 'axios'
// import loc from '../../src/assets/js/location'

export default {
  data: function() {
    return {
      username: '',
      password: '',
      unit: '',
      phonenumber: '',
      nearestStation: ''
    }
  },
  methods: {
    submitForm: function() {
      const url = 'http://localhost:7777/auth/joinProc'
      const form = document.getElementById('firestation').value
      const data = {
        apartname: this.apartname,
        building: this.building,
        unit: this.unit,
        phonenumber: this.phonenumber,
        nearestStation: form
      }
      axios.post(url, data)
        .then(function(response) {
          console.log(response)
          alert('회원가입 성공!')
        })
        .catch(function(error) {
          console.log(error)
          alert('통신 실패')
        })
    },
    please: function() {
      function success(position) {
        const latitude = position.coords.latitude
        const longitude = position.coords.longitude
        // console.log(latitude);
        // console.log(longitude);

        const positions = [
        // 각 지점의 경도, 위도를 배열 형식으로 저장해 놓기 위한 positions 객체 생성
          {
            title: 'myhouse',
            lat: latitude,
            lon: longitude
          },
          {
            title: 'A',
            lat: 37.5103,
            lon: 127.0669
          },
          {
            title: 'B',
            lat: 37.558,
            lon: 126.8601
          },
          {
            title: 'C',
            lat: 37.5293,
            lon: 127.125
          },
          {
            title: 'D',
            lat: 37.4979,
            lon: 126.8653
          },
          {
            title: 'E',
            lat: 37.4737,
            lon: 126.9525
          }
        ]

        const arr = [] // distance를 저장해두는 배열집합
        let distance // haversine 공식으로 나온 거리
        let min // 최소거리
        let minFirestation // 최소 거리에 있는 소방서
        const radius = 6371 // 지구의 반지름
        const toRadian = Math.PI / 180 // 라디안으로 바꾸기 위한 선언

        // Haversine 공식을 이용한 위도, 경도를 이용한 두 지점 사이의 거리 구하기
        for (let i = 1; i < positions.length; i++) {
          const deltaLatitude =
              Math.abs(positions[0].lat - positions[i].lat) * toRadian
          const deltaLongtitude =
              Math.abs(positions[0].lon - positions[i].lon) * toRadian

          const sinDeltaLat = Math.sin(deltaLatitude / 2)
          const sinDeltaLng = Math.sin(deltaLongtitude / 2)
          const squareRoot = Math.sqrt(
            sinDeltaLat * sinDeltaLat +
                Math.cos(positions[0].lat * toRadian) *
                  Math.cos(positions[i].lat * toRadian) *
                  sinDeltaLng *
                  sinDeltaLng
          )
          distance = 2 * radius * Math.asin(squareRoot)

          arr[i] = distance

          console.log(arr[i])
        }
        //   alert("여기까지 왔누");

        min = arr[1]
        for (let i = 2; i < positions.length; i++) {
          if (min > arr[i]) {
            min = arr[i]
            minFirestation = positions[i].title
          // console.log(min_firestation);
          } else {
            continue
          }
        }
        //   alert("여기까지 왔어요");
        //   alert(min_firestation);
        // console.log(document.getElementById("a"));
        document.getElementById('firestation').value = minFirestation // value 값을 넘겨주어서 input으로 받을수 있게 됨!!! 그 후 value를 넘겨줄 수 있나??
        document.getElementById('info').innerText = minFirestation + '소방서로 배정되었습니다!'
        document.getElementById('firestation').style.display = 'none'
      }
      function error() {
        alert('cannot use geolocation api!')
      }
      navigator.geolocation.getCurrentPosition(success, error)
    }

  }

}

</script>

<style scoped>
/* *{
    background-color: black;
  } */
</style>
