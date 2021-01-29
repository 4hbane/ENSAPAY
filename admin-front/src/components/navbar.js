import React from 'react';
class Navbar extends React.Component{
    render(){
        return(
            <nav className="navbar navbar-expand-sm bg-light navbar-light">
            <ul className="navbar-nav">
              <li className="nav-item active">
                <a className="nav-link disabled" href="#">EnsaPay</a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="/">Se connecter</a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="/">Se déconnecter</a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="/ajouter">Ajouter</a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="/afficher">Afficher</a>
              </li>
            
            </ul>
          </nav>
        );
    }
}
export default Navbar;