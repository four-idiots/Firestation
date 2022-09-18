<template>
  <div>
    <v-container>
      <div style="background-color:red">
        {{al()}}
      </div>
      <div>
        <h1>아파트 이름: {{ dataSet.apartname }}</h1>
      </div>
      <br />
      <div>
        <h1>{{ dataSet.building }} 동</h1>
      </div>
      <div>
        <h1>{{ dataSet.unit }} 호</h1>
      </div>
      <br />
      <div>
        <h1>전화번호: {{ dataSet.phonenumber }}</h1>
      </div>
    </v-container>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  components: {},
  data() {
    return {
      dataSet: []
    }
  },
  setup() {},
  created() {},
  mounted() {
    axios
      .get('http://localhost:7777/memberList/C')
      .then((res) => {
        this.dataSet = res.data
      })
      .catch((err) => {
        console.log(err)
      })
  },
  method: {
    al() {
      return this.dataSet + '화재 발생'
    }
  }
}
</script>
