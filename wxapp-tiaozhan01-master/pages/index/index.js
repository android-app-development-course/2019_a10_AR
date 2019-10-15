const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    searchinformation: "",
    mode: "scaleToFill",
    arr: [],
    person: 0,
    percentage: 0,
    indicatorDots: true, //轮播图是否有面板指示点
    autoplay: true,     //轮播图是否自动播放
    interval: 2000,     //轮播图
    duration: 1000,     //轮播图动画时长
    title_content: [
      '基础计划',
      '进阶计划',
      '资深计划',
      '师范技能',
      '职场修炼',
      '名校直通车'
    ],
    daily_mission: [
      {
        mission_pirture: '../../image/project01.jpg',
        mission_name: '初级树人学习'
      },
      {
        mission_pirture: '../../image/project01.jpg',
        mission_name: '高级树人学习'
      }
    ],
    courseLists: [
      {
        course_picture: '../../image/002.png',
        course_teacher: '孙尚香老师'
      },
      {
        course_picture: '../../image/003.png',
        course_teacher: '公孙离老师'
      },
      {
        course_picture: '../../image/004.png',
        course_teacher: '上官婉儿老师'
      },
      {
        course_picture: '../../image/005.png',
        course_teacher: '安吉拉老师'
      }
    ]
  },
  onoptionClick: function (e) {
    var targetUrl = "../demo01/demo01";
    targetUrl = targetUrl + "?title=" + e.currentTarget.dataset.title
    console.log(targetUrl)
    wx.navigateTo({
      url: targetUrl
    });
  },
  ondailyClick: function(e) {
    var targetUrl = "../demo02/demo02";
    targetUrl = targetUrl + "?number=" + e.currentTarget.dataset.number
    console.log(targetUrl)
    wx.navigateTo({
      url: targetUrl
    });
  },
  oncourseClick: function (e) {     //点击相应函数
    var targetUrl = "../demo03/demo03";
    targetUrl = targetUrl + "?courseTeacher=" + e.currentTarget.dataset.course_teacher
    console.log(targetUrl)
    wx.navigateTo({
      url: targetUrl
    });
  },
  
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var array = this.data.arr
    for (let i = 1; i <= 3; i++) {
      array.push("../../image/swiper0" + i + ".jpg")
    }
    this.setData({ arr: array })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function (options) {
    let pages = getCurrentPages(),
    currPage = pages[pages.length - 1];
    this.setData({
      percentage: currPage.data.percentage
    })
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