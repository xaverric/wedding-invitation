import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import RegistrationForm from './components/RegistrationForm';
import LandingPage from './components/landingPage/LandingPage';
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import GuestsList from './components/guestList/GuestsList';

function App() {
  return (
    <div className="App">
      <Router>
        <Switch>
          <Route exact path="/" component={LandingPage}/>
          <Route exact path="/registration/:code" component={props => <RegistrationForm {...props}/>}/>
          <Route exact path="/all" component={GuestsList}/>
        </Switch>
        <Route></Route>
      </Router>
    </div>
  );
}

export default App;
