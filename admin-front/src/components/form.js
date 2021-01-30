import React from 'react';
import './form.css';
import AdminService from "../services/AdminService"
class Form extends React.Component{
    
    constructor(props){
        super(props)
        this.state ={
            nom:'',
            prenom:'',
            piece:'',
            numpiece:'',
            datenaissance:'',
            adresse:'',
            email:'',
            numtelephone:'',
            numimmatriculation:'',
            numpatente:'',
            description:'',
            fichier:''
        };
        this.changePrenomHandler = this.changePrenomHandler.bind(this);
        this.changeNomHandler = this.changeNomHandler.bind(this);
        this.saveAgent = this.saveAgent.bind(this);
    }

    changeNomHandler = (event) =>{
        this.setState({nom: event.target.value})
    }

    changePrenomHandler = (event) =>{
        this.setState({prenom: event.target.value})
    }

    changePieceHandler = (event) =>{
        this.setState({typePieceIdentite: event.target.value})
    }

    changeNumPieceHandler = (event) =>{
        this.setState({numPieceIdentite: event.target.value})
    }

    changeDateNaissanceHandler = (event) =>{
        this.setState({dateNaissance: event.target.value})
    }

    changeAdresseHandler = (event) =>{
        this.setState({adresse: event.target.value})
    }

    changeEmailHandler = (event) =>{
        this.setState({email: event.target.value})
    }

    changeNumTelHandler = (event) =>{
        this.setState({telephone: event.target.value})
    }
    changeNumImmHandler = (event) =>{
        this.setState({immRegistre: event.target.value})
    }

    changeNumPatHandler = (event) =>{
        this.setState({numPatente: event.target.value})
    }

    changeDesHandler = (event) =>{
        this.setState({description: event.target.value})
    }

    changeFichierHandler = (event) =>{
        this.setState({pieceUrl: event.target.value})
    }

    cancel(){
        this.props.history.push('/afficher');
    }

    saveAgent = (e) => {
        e.preventDefault();
        let agent = {nom:this.state.nom, prenom:this.state.prenom,typePieceIdentite :this.state.typePieceIdentite, numPieceIdentite :this.state.numPieceIdentite, 
            dateNaissance:this.state.dateNaissance, adresse:this.state.adresse, email:this.state.email, 
            telephone:this.state.telephone, 
            immRegistre:this.state.immRegistre, numPatente:this.state.numPatente, 
            description:this.state.description, pieceUrl:this.state.pieceUrl};
        console.log('agent => ' + JSON.stringify(agent));

        AdminService.createAgent(agent).then(
            res =>{
                console.log(res);
                this.props.history.push('/afficher');
                console.log(res.data);
            })
            .catch( e=>{
                console.log(e);
            });

    }
    render(){
        return(
            
            <div className="card mb-4 col-md-8">
                <div className="card-body row g-3">
                <form className="row g-3"  method="post">
                <legend className="border-bottom mb-4 col-md-12">Informations personnelles</legend>
                <div className="col-md-6" >
                    <label for="nom" className="col-form-label">Nom</label>
                        <input type="text"  value={this.state.nom} className="form-control" name="nom" onChange={this.changeNomHandler} required/>
                        <div class="invalid-feedback">
                            Veulliez saisir un nom 
                            </div>
                        </div>
                     
                <div className="col-md-6">  
                <label for="prenom" className="col-form-label">Prénom</label>
                    <input type="text" value={this.state.prenom}  className="form-control" name="prenom" onChange={this.changePrenomHandler}/>
                    </div>

                <div className="col-md-6">  
                <label for="typePieceIdentite" className="col-form-label ">Pièce d'identité</label>
                    <select className="form-control" value={this.state.typePieceIdentite} aria-label="Default select example" name="typePieceIdentite" onChange={this.changePieceHandler} >
                        <option value="cin">CIN</option>
                        <option value="passeport" >PASSEPORT</option>
                        <option value="cartesejour">CARTE SEJOUR</option>
                    </select>
                </div>

                <div className="col-md-6">  
                <label for="numPieceIdentite" className="col-form-label">N° pièce d'identité</label>
                    <input type="text"  value={this.state.numPieceIdentite} className="form-control" name="numPieceIdentite" onChange={this.changeNumPieceHandler}/>
                    </div>

                <div class="col-md-6">
                    <label for="dateNaissance" className="col-form-label">Date de naissance</label>
                    <input className="form-control" value={this.state.dateNaissance} type="date" onChange={this.changeDateNaissanceHandler} name="dateNaissance" />
                    </div>
                
                <div className="col-md-6">  
                <label for="adresse" className="col-form-label">Adresse</label>
                    <input type="text"  className="form-control" value={this.state.adresse} name="adresse" onChange={this.changeAdresseHandler}/>
                    </div>
                
                <div className="col-md-6">  
                <label for="email" className="col-form-label">Email</label>
                    <input type="text"  className="form-control" value={this.state.email} name="email" onChange={this.changeEmailHandler}/>
                    </div>
                
                <div className="col-md-6">  
                <label for="confirmationemail" className="col-form-label">Confirmation Email</label>
                    <input type="text"  className="form-control" name="confirmationemail"/>
                    </div>

                <div className="col-md-6">  
                <label for="numtelephone" className="col-form-label">Numéro de téléphone</label>
                    <input type="text"  className="form-control" value={this.state.telephone} name="telephone" onChange={this.changeNumTelHandler}/>
                    </div>

                <div className="col-md-6">  
                <label for="immRegistre" className="col-form-label">N° d'immatriculation au registre de commerce</label>
                    <input type="text"  className="form-control" value={this.state.immRegistre} name="immRegistre" onChange={this.changeNumImmHandler}/>
                    </div>

                <div className="col-md-6">  
                <label for="numPatente" className="col-form-label">N° de patente</label>
                    <input type="text"  className="form-control"  value={this.state.numPatente} name="numPatente" onChange={this.changeNumPatHandler}/>
                    </div>

                <legend className="border-bottom mb-4 col-md-12">Pièces jointes</legend>

                <div className="col-md-6">  
                <label for="description" className="col-form-label">Description</label>
                    <input type="text" placeholder="Description"  value={this.state.description} className="form-control" name="description" onChange={this.changeDesHandler}/>
                    </div>
                
                <div className="col-md-6" >
                <label for="pieceUrl" className="col-form-label">Fichier</label>
                    <input type="file" className="form-control-file"  value={this.state.pieceUrl} name="pieceUrl" onChange={this.changeFichierHandler} />
                    </div>
                
                <div className=" col-md-6" id="buttons">
                <button type="button" className="btn btn-primary btn-sm" onClick={this.saveAgent}  >Enregistrer</button>
                <button type="button" className="btn btn-secondary btn-sm" onClick={this.cancel.bind(this)}>Annuler</button>
                </div>
                </form>
                </div>

            </div>
        );
    }
}
export default Form;