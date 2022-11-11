import * as React from 'react';
import './App.css';
import { Switch, Route, withRouter, RouteComponentProps, Link, BrowserRouter as Router } from 'react-router-dom';
import Displaycustomer from './components/customer/displaycustomer';
import Navbar from "./components/Navbar/Navbar";
import Home from "./components/pages/Home";
import Services from "./components/pages/Services";
import About from "./components/pages/About";
import Security from "./components/pages/Security";
import Help from "./components/pages/Help";

import ImageSlider from './components/ImageSlider';
import {SliderData} from './components/SliderData';

import EditCustomer from './components/customer/Edit';
import Addbranch from './components/customer/Addbranch';
import Displaybranch from './components/Displaybranch';
import Login from './Login';
import Homej from './Homej';
import Addcustomer from './components/customer/Addcustomer';
//import { render } from 'react-dom';
function App() {
//class App extends React.Component<RouteComponentProps<any>> {
 // render() {
    return (
      <div>
        <Router>
        <Navbar/>
        <Switch>
          <Route path={"/"} exact component={Home} />
          <Route path={"/About"} exact component={About} />
          <Route path={"/Services"} exact component={Services} />
          <Route path={"/Security"} exact component={Security} />
          <Route path={"/Help"} exact component={Help} />
          
          <Route path={"/ImageSlider"} exact component={ImageSlider}/>
          
            
        <Route path={'/Login'} exact component={Login} />


          <Route path={'/Displaycustomer'} exact component={Displaycustomer} />
          <Route path={'/Displaybranch'} exact component={Displaybranch} />
          <Route path={'/Addcustomer'} exact component={Addcustomer} />
          <Route path={'/Homej'} exact component={Homej} />
          <Route path={'/edit/:id'} exact component={EditCustomer} />
          <Route path={'/Addbranch'} exact component={Addbranch} />
          
        
        
        
        </Switch>
        <ImageSlider slides={SliderData} />
        </Router>
      </div>
    );
  };


export default App;//withRouter(App);