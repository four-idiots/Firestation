<template>
    <div class="i">
      <form action="/auth/loginProc" method="post">
        <h1>Admin Login</h1>
        <br/>
        <!-- <i class="icon-user"></i><b>ID</b> -->
        <!-- <div>
          <input type="text" v-model="firestationname" placeholder="아이디" />
        </div>
        <br/>
        <i class="icon-key"></i><b>Password</b>
        <div>
          <input type="password" v-model="firestationpassword" placeholder="비밀번호" />
        </div> -->
        <br/>
        <br>
        <div>
          <button id="btn-login" type="submit" @click="submitForm3">Login</button>
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
      fierstationpassword: ''

    }
  },
  methods: {
    submitForm3: function() {
      const url = 'http://localhost:7777/auth/loginProc'
      const data = {
        firestationname: this.firestationname,
        firestationPw: this.firestationPw
      }
      axios.post(url, data)
    }
  }
}
</script>
