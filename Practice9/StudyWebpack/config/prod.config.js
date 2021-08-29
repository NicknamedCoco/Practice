const webpack = require('webpack')
let webpackMerge = require('webpack-merge');
let base = require('./base.config');

module.exports = webpackMerge.merge(base,{
  plugins: [
    new webpack.BannerPlugin('最终版权归万一所有'),
  ],optimization: {
    minimize: true //打开压缩丑化
  }
});