//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    a1src: '/images/menu/新房.png',
    a2src: '/images/menu/二手房.png',
    a3src: '/images/menu/租房.png',
    a4src: '/images/menu/小区.png',
    a5src: '/images/menu/房产专家.png',
    a6src: '/images/menu/视频.png',
    a7src: '/images/menu/资讯.png',
    a8src: '/images/menu/房价.png',
    a9src: '/images/menu/算房贷.png',
    a10src:'/images/menu/估房价.png',
     
  },
  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  onLoad: function () {
    if (app.globalData.userInfo) {
      this.setData({
        userInfo: app.globalData.userInfo,
        hasUserInfo: true
      })
    } else if (this.data.canIUse){
      // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
      // 所以此处加入 callback 以防止这种情况
      app.userInfoReadyCallback = res => {
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    } else {
      // 在没有 open-type=getUserInfo 版本的兼容处理
      wx.getUserInfo({
        success: res => {
          app.globalData.userInfo = res.userInfo
          this.setData({
            userInfo: res.userInfo,
            hasUserInfo: true
          })
        }
      })
    }
  },
  getUserInfo: function(e) {
    console.log(e)
    app.globalData.userInfo = e.detail.userInfo
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
  }
})
