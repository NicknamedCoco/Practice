let webpackMerge = require('webpack-merge');
let base = require('./base.config');

module.exports = webpackMerge.merge(base,{
  //本地服务器的配置
  devServer: {
    watchFiles: './dist',  //表示为哪个文件夹提供本地服务，默认是根文件夹，相对webpack.config.js的路径
    liveReload:true   //是否实时监听文件改动
  },
});

