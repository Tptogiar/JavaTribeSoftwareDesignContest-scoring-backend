module.exports = {
  chainWebpack: config => {
    config.output.filename('[name].[hash].js').end();
  },
  devServer: {
    open: false,
    host: '0.0.0.0',
    port: 8090,
    https: false,
    hotOnly: true,
    proxy: {
      '/': {
        target: "http://localhost:8081",
        changeOrigin: true,
        ws: true,
        secure: false,
        pathRewirte: {
          "^/": ''
        }
      },
      '/ws': {
        target: "ws://localhost:8081",
        changeOrigin: true,
        ws: true,
        secure: false,
        pathRewirte: {
          "^/ws": ''
        }
      }
    }
  },
  assetsDir: 'assets',
  css: {
    loaderOptions: {
      less: {
        // 若 less-loader 版本小于 6.0，请移除 lessOptions 这一级，直接配置选项。
        lessOptions: {
          modifyVars: {
            // 直接覆盖变量
            'font-size-md': '20px',
            "notice-bar-height": '50px'
          },
        },
      },
    },
  },
};