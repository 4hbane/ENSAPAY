import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Form from "./components/form";
import Listagent from "./components/listagent";
import Navbar from "./components/navbar";
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'

function App() {
  return (
    <div>
      <Router>
        <Navbar/>
          <div className="container">
             <Switch>
              <Route path="/ajouter" component={Form}></Route>
              <Route path="/afficher" component={Listagent}></Route>
              </Switch>
          </div>
    </Router>
    </div>
  );
}

export default App;
