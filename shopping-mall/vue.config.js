const {defineConfig} = require('@vue/cli-service')
module.exports = defineConfig({
    transpileDependencies: true,
    lintOnSave: 'warning',
    devServer: {
        proxy: {
            '/api': {
                target: 'http://202.193.53.235:8080',
                pathRewrite: {'^/api': ''},
                // ws: true, //用于支持websocket,默认值为true
                // changeOrigin: true //用于控制请求头中的host值,默认值为true
            }
        }
    }
})