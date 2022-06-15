    
import React from 'react';
import logo from '../../images/logo/logo192.png';
import '../../App.css';
    
class Header extends React.Component{

render(){

    return (
    <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
          <strong>Skill Tracker</strong>
          <div className="Admin-panel"><strong>ADMIN PANEL</strong></div>
      </header>
    )};
}
 
export default Header;