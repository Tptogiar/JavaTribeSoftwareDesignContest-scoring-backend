  module.exports = {
    presets: [
      // '@vue/app',
      '@vue/cli-plugin-babel/preset'
    ],
    plugins: [
      ['import', {
        libraryName: 'vant',
        libraryDirectory: 'es',
        style: true,
      }, 'vant']
    ]
  }

