//因为全局安装中存在vue，所以可以直接导入vue的path模块
const path = require('path');

const htmlWebpackPlugin = require('html-webpack-plugin');

//Common.js语法导出
module.exports={
  entry: './src/main.js', //打包入口，相对于webpack.config.js，main.js所在的位置
  output:{
    /*
      path是出口路径，指要把打包后的文件放在哪里，__dirname是path模块的变量，表示当前文件的绝对路径
      该变量表示当前webpack.config.js的绝对路径，resolve函数表示将两个路径进行自动拼接
      所以整体意思就是打包后文件放在webpack.config.js同级的dist目录中
     */
    path:path.resolve(__dirname,'../dist'),
    filename: 'bundle.js',    //打包后的文件名
  },
  module: {
    rules: [
      {
        //css的loader
        test: /\.css$/,
        use: [ 'style-loader', 'css-loader' ]
      },{
        //less的loader
        test: /\.less$/,
        use: [{
          loader: "style-loader" // creates style nodes from JS strings
        }, {
          loader: "css-loader" // translates CSS into CommonJS
        }, {
          loader: "less-loader" // compiles Less to CSS
        }]
      },{
        //文件上传的loader
        test: /\.(png|jpg|gif|jpeg)$/,
        use: [
          {
            loader: 'url-loader',
            options: {
              limit: 8192,
              name:'img/[name].[hash:8].[ext]',
              // outputPath: './',   //输出路径，这里路径是：path(上面的)+outputPath+name路径
              // publicPath: 'dist/'
              /*
                在url-loader内部封装了file-loader而file-loader在新版本中esModule属性默认为true
                即默认使用ES模块语法导致了引用图片文件的方式和以前的版本不一样,引入路径改变了，自然找不到图片。
               */
              esModule: false
            },
          }
        ],
        /*
          当在webpack 5中使用旧的assets loader（如 file-loader/url-loader/raw-loader 等）和asset模块时，
          这可能会导致asset重复，所以你可能想阻止webpack 5内置的asset模块的处理，
          你可以通过将asset模块的类型设置为‘javascript/auto’来解决。
         */
        type: 'javascript/auto'
      },{
        //es6转es5的loader
        test: /\.js$/,
        exclude: /(node_modules|bower_components)/,
        use: {
          loader: 'babel-loader',
          options: {
            presets: ['@babel/preset-env']
          }
        }
      },{
        //vue-loader
        test: /\.vue$/,
        use: ['vue-loader']
      }
    ]
  },resolve: {
    //vue配置
    alias: {
      'vue$':'vue/dist/vue.esm.js'
    }
  },plugins: [
    new htmlWebpackPlugin({
      /*
        用于生成dist/index.html的模板，模板中并不需要写script标签引入bundle.js，
        插件会自动引用
      */
      template: 'index.html'
    })
  ],
  // mode: 'development', //设置webpack模式
  // watch: true  // 监听文件改动并自动打包
}