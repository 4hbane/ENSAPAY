import React from 'react';
import AdminService from "../services/AdminService"

class Listagent extends React.Component{
    constructor(props){
        super(props)
        this.state = {
            agents: []
        }
    }
    componentDidMount(){
        AdminService.getAllAgent().then((res) =>
        {
            console.log(res);
            this.setState({agents: res.data});

        });
      
    }
    render() {
        return(
        <div className="card mb-4 col-md-8">
            <div className="card-body row g-3">
            <div className="row">
                <table className="table table-striped table-bordered">
                    <thead>
                        <tr>
                            <th>Nom</th>
                            <th>Prénom</th>
                            <th>Date de naissance </th>
                            <th>Numéro pièce d'identité </th>
                            <th>Numéro patente </th>
                        </tr>
                    </thead>
                    <tbody>
                        { this.state.agents.map(
                            agent => 
                            <tr key={agent.id}>
                                <td> { agent.nom}</td>
                                <td> { agent.prenom}</td>
                                <td>{agent.dateNaissance }</td>
                                <td>{agent.numPieceIdentite}</td>
                                <td> {agent.numPatente}</td>
                            </tr>
                        )

                        }
                    </tbody>

                </table>
            </div>
            </div>
        </div>
    )};
    
}

export default Listagent;