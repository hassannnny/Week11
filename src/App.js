import logo from './logo.svg';
import './App.css';
import Home from "./Components/Home"
import Login from './Components/Login';
import NavBar from './Components/NavBar';
import SignUp from './Components/SignUp';
import Templates from './Components/Templates';


function App() {

  let Component 
  switch (window.location.pathname) {
    case "/":
      Component =<Home />
      break;
    case "/login":
      Component =<Login />
      break;
    case "/signup":
      Component =<SignUp />
    break;
    case "/templates":
      Component =<Templates />
    break;
  } 



  return (

    <div className='App'>
      <NavBar /> 
      {Component}
    </div>
  )
}

export default App;
