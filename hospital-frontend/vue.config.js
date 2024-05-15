module.exports = {
    lintOnSave: false,
    devServer: {
        host: "0.0.0.0",
        port: 80,
        https: false,
        proxy: "http://127.0.0.1:9281",
        allowedHosts: ['se.yuntianyang.com'],
        overlay: {
            warning: false,
            errors: false
        },
    }
}
