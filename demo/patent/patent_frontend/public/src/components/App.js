import React, {Component} from 'react';
import axios from 'axios';

import {Link} from 'react-router-dom'

import '../../style/index.css';

export default class App extends Component {
    constructor(props) {
        super(props);
        this.changeClassNumber = this.changeClassNumber.bind(this);
        this.changeCourseName = this.changeCourseName.bind(this);
        this.changeCourseHour = this.changeCourseHour.bind(this);
        this.changeCategoryNumber = this.changeCategoryNumber.bind(this);
        this.changeContentNumber = this.changeContentNumber.bind(this);
        this.submit = this.submit.bind(this);
        this.state = {
            classNumber: null,//年份
            year: null, //年
            province: null, //地区
            category: null,//分类
            content: null,//内容
            result: null, //结果
            courseInfo: [],
            currentCourse: null
        }
    }

    changeClassNumber(e) {
        this.setState({classNumber: e.target.value});
        this.setState({year: e.target.value});
    }

    changeCategoryNumber(e) {
        this.setState({category: e.target.value});
    }
    
    changeContentNumber(e) {
        this.setState({content: e.target.value});
    }

    changeCourseName(e) {

        let courseInfo = this.state.courseInfo;

        this.setState({currentCourse: e.target.value});
        this.setState({province: e.target.value});

        const newCourseInfo = {
            courseHour: 0,
            courseName: e.target.value
        }

        const existedCourse = courseInfo.find(item => item.courseName === e.target.value);
        if (existedCourse) {
            return;
        }

        courseInfo.push(newCourseInfo);
        this.setState({courseInfo});
    }

    changeCourseHour(e) {
        const {currentCourse, courseInfo} = this.state;

        const newCourseInfo = courseInfo.map(item => {
            if (item.courseName === currentCourse) {
                item.courseHour = e.target.value;
            }
            return item;
        })
        this.setState({courseInfo: newCourseInfo});
    }

    submit() {
        const data = Object.assign({province: this.state.province},{category: this.state.category}, {year: this.state.year}, {content: this.state.content});
        
        axios.post('http://localhost:8090/hello', data, 
            {
                headers: {
                'Content-Type': 'application/json'
            }
        }).then(res => {
            console.log(res.data);
            if(this.state.category === "发明"){
                this.setState({result : res.data.invent});
            }
            if(this.state.category === "实用新型"){
                this.setState({result : res.data.practical});
            }
            if(this.state.category === "外观设计"){
                this.setState({result : res.data.aspect});
            }
        })
    }

    render() {
        return (
            <div className="app-container">
                <img src="../src/image/home.jpeg" alt=""/>
                <div className="left-form">
                    <div className="one-line row">
                        <label className="item" htmlFor="classNumber">年份</label>
                        <select className="item select-width form-control"
                                id="classNumber" onChange={this.changeClassNumber}>
                            <option selected value="请选择年份" disabled>请选择年份</option>
                            <option value="2011">2011</option>
                            <option value="2012">2012</option>
                            <option value="2013">2013</option>
                            <option value="2014">2014</option>
                            <option value="2015">2015</option>
                        </select>
                    </div>
                    <div className="one-line row">
                        <label className="item" htmlFor="courseType">地区</label>
                        <select className="item select-width form-control" id="courseType"
                                onChange={this.changeCourseName}>
                            <option selected value="请选择地区" disabled>请选择地区</option>
                            <option value="北京">北京</option>
                            <option value="天津">天津</option>
                            <option value="河北">河北</option>
                            <option value="山西">山西</option>
                            <option value="内蒙古">内蒙古</option>
                            <option value="辽宁">辽宁</option>

                            <option value="吉林">吉林</option>
                            <option value="黑龙江">黑龙江</option>
                            <option value="上海">上海</option>
                            <option value="江苏">江苏</option>
                            <option value="浙江">浙江</option>
                            <option value="安徽">安徽</option>
                            <option value="福建">福建</option>
                            <option value="江西">江西</option>
                            <option value="山东">山东</option>
                            <option value="河南">河南</option>
                            <option value="湖北">湖北</option>
                            <option value="湖南">湖南</option>
                            <option value="广东">广东</option>
                            <option value="广西">广西</option>
                            <option value="海南">海南</option>
                            <option value="重庆">重庆</option>
                            <option value="四川">四川</option>
                            <option value="贵州">贵州</option>
                            <option value="云南">云南</option>
                            <option value="西藏">西藏</option>
                            <option value="陕西">陕西</option>
                            <option value="甘肃">甘肃</option>
                            <option value="青海">青海</option>
                            <option value="宁夏">宁夏</option>

                            <option value="新疆">新疆</option>
                            <option value="香港">香港</option>
                            <option value="澳门">澳门</option>
                            <option value="台湾">台湾</option>
                            <option value="广州">广州</option>
                            <option value="长春">长春</option>
                            <option value="武汉">武汉</option>
                            <option value="南京">南京</option>
                            <option value="杭州">杭州</option>
                            <option value="西安">西安</option>
                            <option value="济南">济南</option>
                            <option value="沈阳">沈阳</option>
                            <option value="成都">成都</option>
                            <option value="大连">大连</option>
                            <option value="厦门">厦门</option>
                            <option value="哈尔滨">哈尔滨</option>
                            <option value="深圳">深圳</option>
                            <option value="青岛">青岛</option>
                            <option value="宁波">宁波</option>
                            <option value="新疆兵团">新疆兵团</option>
                    
                        </select>
                    </div>
                    {
                        this.state.currentCourse && (
                            <div className="row one-line">
                                <label className="item">专利类别</label>
                                <select className="item select-width form-control"
                                    id="classNumber" onChange={this.changeCategoryNumber}>
                                    <option selected value="请选择专利类别" disabled>请选择专利类别</option>
                                    <option value="发明">发明</option>
                                    <option value="实用新型">实用新型</option>
                                    <option value="外观设计">外观设计</option>
                                </select>
                            </div>
                        )
                    }

                    {
                        this.state.currentCourse && (
                            <div className="row one-line">
                                <label className="item">查询内容</label>
                                <select className="item select-width form-control"
                                    id="classNumber" onChange={this.changeContentNumber}>
                                    <option selected value="请选择查询内容" disabled>请选择查询内容</option>
                                    <option value="申请量">申请量</option>
                                    <option value="授予量">授予量</option>
                                </select>
                            </div>
                        )
                    }
                </div>
                <div className="select-info">
                    {/*<img src="../src/image/home.jpeg" alt=""/>*/}
                    <div>
                        <h3>我们将按照以下条件为您查询：</h3>
                             <div className="info">
                                <div>时间:{this.state.classNumber}</div>
                                <div>地区:{this.state.province}</div>
                                <div>类别:{this.state.category}</div>
                                <div>内容:{this.state.content}</div>
                            </div>
                        <h3>查询结果：</h3>
                            <div className="info">
                                <div>结果:{this.state.result}</div>
                            </div>
                    </div>
                    <div className="submit">
                        <button type="button" className="btn btn-warning" onClick={this.submit}
                                disabled={this.state.currentCourse ? '' : 'disabled'}>
                          开始查询
                        </button>                        
                    </div>

                </div>
            </div>
        )
    }
}

