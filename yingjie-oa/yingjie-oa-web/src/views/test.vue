<template>
  <div>
    <div>账号切换</div>
    <button @click="zs()" type="default" size="mini">张三</button>
    <button @click="ls()" type="default" size="mini">李四</button>
    <button @click="zzjl()" type="default" size="mini">张总经理</button>
    <button @click="admin()" type="default" size="mini">admin</button>
    <div>当前token：{{ token }}</div>
  </div>
</template>

<script>
export default {
  name: "Test",

  data() {
    return {
      token: ''
    };
  },

  created(){
    this.token = window.localStorage.getItem('token')
  },

  methods: {
    zs() {
      window.localStorage.setItem('token', '');
      let token = 'eyJhbGciOiJIUzUxMiIsInppcCI6IkdaSVAifQ.H4sIAAAAAAAAAKtWKi5NUrJScgwN8dANDXYNUtJRSq0oULIyNDczMDU0MzMz0lEqLU4t8kxRsjKHMPMSc1OBWqoyEvPSixPzlGoBd1eos0UAAAA.x3JmxCVZ_1hzpU37wj05fZxYIswahJeW7hHYh3QDx_Vem6xXHnvY1Id2ppdMU3LBavHoMQ4CeDhh53bh6DbGYA'
      window.localStorage.setItem('token', token);
      this.token = window.localStorage.getItem('token')
    },

    ls() {
      window.localStorage.setItem('token', '');
      let token = 'eyJhbGciOiJIUzUxMiIsInppcCI6IkdaSVAifQ.H4sIAAAAAAAAAKtWKi5NUrJScgwN8dANDXYNUtJRSq0oULIyNDczMDU2NjM11lEqLU4t8kxRsjKBMPMSc1OBWnIyizOVagHk4XM7QQAAAA.AYmAetIflzM5-wHbs9haNokUdRYAJLJJXXeoc496B_LmCO4jLTHX-E6-XVMuqOfrWQuyQnAkIAmVH_6wqt3Kgg'
      window.localStorage.setItem('token', token);
      this.token = window.localStorage.getItem('token')
    },

    zzjl() {
      window.localStorage.setItem('token', '');
      let token = 'eyJhbGciOiJIUzUxMiIsInppcCI6IkdaSVAifQ.H4sIAAAAAAAAAKtWKi5NUrJScgwN8dANDXYNUtJRSq0oULIyNDM3NjMwNLYw11EqLU4t8kxRsjKFMPMSc1OBWqqqsnKUagGHebUNQQAAAA.FcCkD6QfaP8bd_3MYsRD6Tp9wr9JSRFWIUuIdG5O7XxhIeyWfzGLp40_Lesx_kWMMaaskh_ba3NrTlj8-nP6OA'
      window.localStorage.setItem('token', token);
      this.token = window.localStorage.getItem('token')
    },

    admin() {
      window.localStorage.setItem('token', '');
      let token = 'eyJhbGciOiJIUzUxMiIsInppcCI6IkdaSVAifQ.H4sIAAAAAAAAAKtWKi5NUrJScgwN8dANDXYNUtJRSq0oULIyNDczMDU0MzMw0FEqLU4t8kwBikGYeYm5qUAtiSm5mXlKtQDqbkACQgAAAA.FbqbiFFNEy5kCo5mBFB2rM68fHvISgGYxyDsuhbrQpXb_GgxFZ3EBYxDlLu8XyMH4kKM-Y0sF7gSa4CntaX9gw'
      window.localStorage.setItem('token', token);
      this.token = window.localStorage.getItem('token')
    }
  }
}
</script>
