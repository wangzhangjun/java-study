import React, {Component} from 'react';
import axios from 'axios';

import '../../style/courseTable.css';

export default class CourseTable extends Component {
  constructor(props) {
    super(props);
    this.getUploadFilename = this.getUploadFilename.bind(this);
    this.changeClassNumber = this.changeClassNumber.bind(this);
    this.state = {
      uploadFileName: '请选择文件',
      classNum: 1,
      course: [],
      classIndex: -1
    }
  }

  componentDidMount() {
    //一进这个页面就会执行,默认获取第1个班级的课表
    axios.get('http://localhost:5000/api/course/1').then(res => {
      this.setState({
        course: res.data.classTable,
        classNum: res.data.classNumber
      });
    })
  }

  getUploadFilename(e) {
    this.setState({uploadFileName: e.target.files[0].name});
    axios.post(`http://localhost:5000/api/course/${this.state.classIndex}/upload`, {'fileName': e.target.files[0].name}).then(res => {
      console.log(res);
    })
  }

  changeClassNumber(e) {
    const num = e.target.value;
    //发送哪个班级的请求，设置数据
    axios.get(`http://localhost:5000/api/course/${num}`).then(res => {
      this.setState({
        course: res.data.classTable,
        classNum: res.data.classNumber,
        classIndex: num,
        uploadFileName: '请选择文件'
      });
    })
  }

  render() {
    let title = '';
    let arr = Array.from({length: this.state.classNum}, (v, k) => k);
    return (
        <div className="container course-main">
          <div className="row main ">
            <div className="col-md-4 class-nav">
              <img src="../src/image/course.jpeg" alt=""/>
              <div className="row left">
                <label className="item" htmlFor="classNumber">选择班级</label>
                <select className="item select-width form-control"
                        id="classNumber" onChange={this.changeClassNumber}>
                  <option selected value="请选择班级个数" disabled>{'1班'}</option>
                  {
                    arr.map((i, index) => {
                      return <option key={index} value={i+1}>{(i+1).toString()}班</option>
                    })
                  }
                </select>
              </div>
              <div className="upload-file">
                {this.state.uploadFileName}
              </div>
              <div className="feature">
                <div className="printer-btn">
                  打印
                </div>
                <div align="center" className="upload-button">
                                <span className="btn fileinput-button">
                                <span>上传</span>
                                 <input id="loadfile" type="file" onChange={this.getUploadFilename}/>
                                 </span>
                </div>
              </div>
            </div>


            <div className="col-md-8 class-course table-responsive">
              <table className="col-md-12 text-center">
                <tbody>
                <tr className="text-center table-header">
                  <th>课表</th>
                  <th>周一</th>
                  <th>周二</th>
                  <th>周三</th>
                  <th>周四</th>
                  <th>周五</th>
                </tr>
                {
                  this.state.course.map((item, index) => {
                    if (index === 0) title = '第一节';
                    else if (index === 1) title = '第二节';
                    else if (index === 2) title = '第三节';
                    else if (index === 3) title = '第四节';
                    else if (index === 4) title = '第五节';
                    else if (index === 5) title = '第六节';
                    else if (index === 6) title = '第七节';
                    else title = '第八节';
                    return (
                        <tr>
                          <td>{title}</td>
                          <td>{courses[item[0]]}</td>
                          <td>{courses[item[1]]}</td>
                          <td>{courses[item[2]]}</td>
                          <td>{courses[item[3]]}</td>
                          <td>{courses[item[4]]}</td>
                          <td>{courses[item[5]]}</td>
                          <td>{courses[item[6]]}</td>
                          <td>{courses[item[7]]}</td>
                        </tr>
                    )
                  })
                }
                </tbody>
              </table>
            </div>
          </div>
        </div>
    );
  }
}

const courses = {
  'chinese': '语文',
  'math': '数学',
  'english': '英语',
  'art': '美术',
  'sport': '体育',
  'music': '音乐'
}
