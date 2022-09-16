<template>
  <div style="height: 100%">
    <header>화재 감지 서비스</header>
    <nav>
      <router-link
        type="button"
        to="/user/register"
        class="menu-bar"
        id="fire-car"
        >User Register
        <div class="b"><router-view name="view1" />

        </div>
      </router-link>

      <router-link
        type="button"
        to="/admin/register"
        class="menu-bar"
        id="fire-fighter"
        >Admin Register
        <div class="b"><router-view name="view2"/></div>
      </router-link>

      <router-link
        type="button"
        to="/admin/login"
        class="menu-bar"
        id="fire-station"
        >Admin Login
        <router-view name="view3" class="b" />
      </router-link>

    </nav>
  </div>
</template>
<script>
export default {

}
</script>
