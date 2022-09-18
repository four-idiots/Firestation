<template>
  <div style="height: 1080px">
    <header><b id="title">Fire Detection Service</b> <span id=guide><a @click="description()">Service Guide</a></span></header>
    <div style="height: 972px;">
      <div id="article">
        <div class="b" id="b1"><router-view name="view1" /></div>
        <div class="b" id="b2"><router-view name="view2" /></div>
        <div class="b" id="b3"><router-view name="view3" /></div>
      </div>
        <nav id="n">
          <router-link
            type="button"
            to="/user/register"
            class="menu-bar"
            id="fire-car"
            @click="changea()"
            >User Register
          </router-link>

          <router-link
            type="button"
            to="/admin/register"
            class="menu-bar"
            id="fire-fighter"
            @click="changeb()"
            >Admin Register
          </router-link>

          <router-link
            type="button"
            to='/admin/login'
            class="menu-bar"
            id="fire-station"
            @click="changec()"
            >Admin Login
          </router-link>
        </nav>

    </div>
  </div>
</template>
<script>
export default {
  methods: {
    changea() {
      document.getElementById('b1').style.zIndex = 1
      document.getElementById('b1').style.height = '670px'
      document.getElementById('b2').style.height = '1px'
      document.getElementById('b3').style.height = '1px'
      document.getElementById('b2').style.zIndex = -1
      document.getElementById('b3').style.zIndex = -1
    },
    changeb() {
      document.getElementById('b2').style.zIndex = 1
      document.getElementById('b2').style.height = '670px'
      document.getElementById('b1').style.height = '1px'
      document.getElementById('b3').style.height = '1px'
      document.getElementById('b1').style.zIndex = -1
      document.getElementById('b3').style.zIndex = -1
    },
    changec() {
      document.getElementById('b3').style.zIndex = 1
      document.getElementById('b3').style.height = '670px'
      document.getElementById('b1').style.height = '1px'
      document.getElementById('b2').style.height = '1px'
      document.getElementById('b1').style.zIndex = -1
      document.getElementById('b2').style.zIndex = -1
    },
    description() {
      const myWindow = window.open('', 'MsgWindow', 'width=1000,height=350,location=no,scrollbars=no,toolbars= no,status= no,left=230px,top=200px')
      myWindow.document.write(
        '<h4>사람이 인지하지 못한 화재에 대응하는 서비스입니다.</h4>',
        '<p>원리:화재 감지 센서와 AI 기술을 이용하여, 화재 발생시 자동으로 주변 소방서에 알림을 전송합니다.</p>',
        '<br/><기대효과><ul><li>빠른 대응으로 더 큰 화재 피해 방지<li>사람이 인지하지 못한 화재 대응 가능<li>빈 집 화재 대응 가능</ul>',
        '<br/><p>많은 화재가 조기에 인지 하지 못해, 대응이 늦어져 큰 인명피해를 야기시키고 있습니다.<br/>서비스에 가입하여 화재로 인한 큰 인명피해를 방지하세요! '
      )
    }
  }
}
</script>
