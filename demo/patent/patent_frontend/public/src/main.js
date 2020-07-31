import React from 'react';
import ReactDOM from 'react-dom';
import App from './components/App';
import CourseTable from './components/CourseTable';
import Nav from './components/Nav';
import SearchInfo from './components/SearchInfo';


import {
    BrowserRouter as Router,
    Route,
    Link
} from 'react-router-dom';

const BasicExample = () => (
  <Router>
    <div>
      <Route exact path="/" component={Home}/>
      <Route path="/courseTable" component={CourseDetail}/>
      <Route path="/searchInfo" component={SearchDetail}/>
    </div>
  </Router>
)

const Home = () => {
    return <div>
        <Nav/>
        <App/>
    </div>
}
const CourseDetail = () => {
    return <div>
        <Nav/>
        <CourseTable/>
    </div>
}

const SearchDetail = () => {
    return <div>
        <Nav/>
        <SearchInfo/>
    </div>
}

ReactDOM.render(<BasicExample/>, document.getElementById('app'));
