import axios from 'axios';

const AGENT_API_BASE_URL="http://localhost:8085/Agent";


class AdminService{

    createAgent(agent){
        return axios.post(`${AGENT_API_BASE_URL}/addAgent`, agent);
    }
    getAllAgent(){
        return axios.get(`${AGENT_API_BASE_URL}/Agents`);
    }
}

export default  new AdminService();