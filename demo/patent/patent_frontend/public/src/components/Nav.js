import React, {Component} from 'react';
import axios from 'axios';

import '../../style/nav.css';
import {Link} from 'react-router-dom'

export default class Nav extends Component {

    render() {
        return (
            <nav className="navbar navbar-expand-lg navbar-light bg-light">
                <Link to="/">
                <a className="navbar-brand">专利查询系统</a>
                </Link>
                <div className="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <div className="navbar-nav">
                   
                    </div>
                </div>
            </nav>
        )
    }
}
