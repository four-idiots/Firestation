<template>
  <div class="i">
    <form>
      <h1>Admin Register</h1>
      <br/>
      <i class="icon-user"></i><b>ID</b>
      <div>

        <input type="text" v-model="firestationname" placeholder="아이디" />
      </div>
      <br/>
      <i class="icon-key"></i><b>Password</b>
      <div>

        <input type="password" v-model="firestationPw" placeholder="비밀번호" />
      </div>
      <br/>
      <div>
        <button id="btn-login" type="submit" @click="submitForm2">Login</button>
      </div>
    </form>

  </div>
</template>

<script>
import axios from 'axios'
export default {
  data() {
    return {
      firestationname: '',
      firestationPw: ''
    }
  },
  methods: {
    submitForm2: function() {
      const url = 'http://localhost:7777/auth/FirejoinProc'
      const data = {
        firestationname: this.firestationname,
        firestationPw: this.firestationPw
      }
      axios.post(url, data)
        .then(function(response) {
          alert('성공')
          console.log(response)
        })
        .catch(function(error) {
          console.log(error)
          alert('실패')
        })
    }
  }
}
</script>
<style>

</style>
