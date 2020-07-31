import React, {Component} from 'react';
import axios from 'axios';

import '../../style/searchInfo.css';

export default class SearchInfo extends Component {
    constructor(props) {
        super(props);
        this.state = {
            classes: [1,2,3,4,5],
            fileName: '',
            file: '',
            classIndex: '',
        }
        this.handleChange = this.handleChange.bind(this);
        this.submit = this.submit.bind(this);
        this.toggleClass = this.toggleClass.bind(this);

    }

    handleChange(e) {
        this.setState({fileName: e.target.value});
    }

    submit() {
        const fileName = this.state.fileName;
        axios.get(`http://localhost:5000/api/search/${fileName}`).then(res => {
            this.setState({file: res.data.file, classIndex: res.data.classIndex});
        });
    }

    toggleClass(item) {
        axios.get(`http://localhost:5000/api/file/${item}`).then(res => {
            this.setState({file: res.data.file, classIndex: item});
        });
    }

    componentDidMount() {
        //一进这个页面就会执行,默认获取第1个班级的课表
        axios.get('http://localhost:5000/api/course/0').then(res => {
            this.setState({
                classes: Array.from({length: res.data.classNumber}, (v, k) => k)
            });
        })
    }

    render() {
        console.log(this.state.classIndex);
        return (
            <div className="main-content">
              <img src="../src/image/home5.jpeg" alt=""/>
                <div className="classes">
                    {this.state.classes.map((item, index) => {
                        return <div key={index} className="item" onClick={() => this.toggleClass(item)}>{item}</div>
                    })}
                </div>
                <div className="search-form">
                    <div className="input-form">
                        <input type="text" className="form-control" placeholder="请输入文件名" onChange={this.handleChange}/>
                        <button type="button" className="btn btn-warning" onClick={this.submit}>搜索</button>
                    </div>
                        <div className="right-bar">
                            {
                                this.state.classIndex && (
                                    <div>班级：{this.state.classIndex > 0 ? this.state.classIndex : ''}班 &nbsp;&nbsp;&nbsp;&nbsp;</div>
                                )
                            }
                            {
                                this.state.file && (
                                    <div>数据：{this.state.file ? this.state.file: '暂无'}</div>
                                )
                            }
                        </div>
                </div>
            </div>

        )
    }
}
