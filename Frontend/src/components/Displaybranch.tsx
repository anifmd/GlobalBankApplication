import * as React from 'react';
import { Link, RouteComponentProps } from 'react-router-dom';
import axios from 'axios';


interface IState {
    branches: any[];
}

export default class Home extends React.Component<RouteComponentProps, IState> 
{
    constructor(props: RouteComponentProps) {
        super(props);
        this.state = { branches: [] }
    }

    componentDidMount(): void {
        axios.get(`http://localhost:8084/branches`).then(data => {
            this.setState({ branches: data.data })
        })
    }

    deleteCustomer(id: number) {
        axios.delete(`http://localhost:8084/branches/delete/${id}`).then(data => {
            const index = this.state.branches.findIndex(branch => branch.id === id);
            this.state.branches.splice(index, 1);
            this.props.history.push('/Displaybranch');
        })
    }

    render() {
        const branches = this.state.branches;
        return (
            <div className='ads'>

            <div className='hss'>
                <nav>
                <ul>
                    <li>
                    <Link to={'/Homej'}>  Home </Link>
                    <li>                         </li>
                    <li>                         </li>
                    <li>                         </li>
                    <li>                         </li>
                    <li>                         </li>
                    <li>                         </li>
                    <li>                         </li>
                    <li>                         </li>
                    <li>                         </li>
                    <li>                         </li>
                    <li>                         </li>
                    </li>
                    <Link to={'/'}><button className="btn btn-sm btn">Logout</button></Link>
                   
                </ul>
                </nav>
                {branches.length === 0 && (
                    <div className="text-center">
                        <br>
                        </br>
                        <br>
                        </br>
                        <h2>No customer found at the moment</h2>
                    </div>
                )}

                <div className="container">
                    <div className="row">
                        <table className="table table-bordered">
                            <thead className="thead-light">
                                <tr>
                                    <th scope="col">Branch Id</th>
                                    <th scope="col">Branch Name</th>
                                    <th scope="col">City</th>
                                    
                                   
                                    <th scope="col">Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {branches && branches.map(branch =>
                                    <tr key={branch.id}>
                                        <td>{branch.id}</td>
                                        <td>{branch.name}</td>
                                        <td>{branch.city}</td>
                                        
                                        
                                        <td>
                                            <div className="d-flex justify-content-between align-items-center">
                                                <div className="btn-group" style={{ marginBottom: "20px" }}>
                                                    
                                                    <Link to={'/displaycusomer'}><button className="btn btn-sm btn-danger" onClick={() => this.deleteCustomer(branch.id)}>Delete Branch</button></Link>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                )}
                            </tbody>
                        </table>
                    </div>
                </div>
                </div>
                
            </div>
        )
    }
}
