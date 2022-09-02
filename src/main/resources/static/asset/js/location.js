navigator.geolocation.getCurrentPosition(function (pos) {
  let min_firestation;
  var latitude = pos.coords.latitude;
  var longitude = pos.coords.longitude;
  var positions = [
    //각 지점의 경도, 위도를 배열 형식으로 저장해 놓기 위한 positions 객체 생성
    {
      title: "myhouse",
      lat: latitude,
      lon: longitude,
    },
    {
      title: "A",
      lat: 37.5103,
      lon: 127.0669,
    },
    {
      title: "B",
      lat: 37.558,
      lon: 126.8601,
    },
    {
      title: "C",
      lat: 37.5293,
      lon: 127.125,
    },
    {
      title: "D",
      lat: 37.4979,
      lon: 126.8653,
    },
    {
      title: "E",
      lat: 37.4737,
      lon: 126.9525,
    },
  ];
  let arr = []; //distance를 저장해두는 배열집합
  let distance; //haversine 공식으로 나온 거리
  let min; //최소거리
  //최소 거리에 있는 소방서
  let radius = 6371; //지구의 반지름
  let toRadian = Math.PI / 180; //라디안으로 바꾸기 위한 선언

  //Haversine 공식을 이용한 위도, 경도를 이용한 두 지점 사이의 거리 구하기
  for (let i = 1; i < positions.length; i++) {
    let deltaLatitude =
      Math.abs(positions[0].lat - positions[i].lat) * toRadian;
    let deltaLongtitude =
      Math.abs(positions[0].lon - positions[i].lon) * toRadian;

    let sinDeltaLat = Math.sin(deltaLatitude / 2);
    let sinDeltaLng = Math.sin(deltaLongtitude / 2);
    let squareRoot = Math.sqrt(
      sinDeltaLat * sinDeltaLat +
        Math.cos(positions[0].lat * toRadian) *
          Math.cos(positions[i].lat * toRadian) *
          sinDeltaLng *
          sinDeltaLng
    );
    distance = 2 * radius * Math.asin(squareRoot);

    arr[i] = distance;
  }

  min = arr[1];
  for (let i = 2; i < positions.length; i++) {
    if (min > arr[i]) {
      min = arr[i];
      min_firestation = positions[i].title;
    } else {
      continue;
    }
  }
  console.log(min_firestation);
  document.getElementById("info").innerText =
    "정보가 공유 될 인접 소방서는 "+min_firestation + "입니다.";
  $("input[name=station]").attr("value", min_firestation);
});
