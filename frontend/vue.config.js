module.exports = {
  //추가
  outputDir: '../backend/src/main/resources/static',

  devServer: {
      port: 8080,
      proxy: {
          '/api': {
              target: 'http://localhost:7777',
              ws: true,
              changeOrigin: true
          }
      }
  }
}
