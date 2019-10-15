// pages/demo02/demo02.js
Page({
  data: {
    percentage: -1,
  },

  back: function (e) {
    this.data.percentage++;
    var pages = getCurrentPages();
    var prevPage = pages[pages.length - 2];
    this.setData({
      percentage: this.data.percentage
    })
    prevPage.setData({
      percentage: this.data.percentage
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(options.number)
    this.setData({
      percentage: options.number
    })
    console.log(this.data.percentage)
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})