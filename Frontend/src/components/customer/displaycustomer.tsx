import * as React from 'react';
import { Link, RouteComponentProps } from 'react-router-dom';
import axios from 'axios';

export default function displaycustomerapp(){
    const [customer, setcustomer ]= React.useState([{"id":1,"name":"Rishab","status":false,"openingDate":"66578","openingBalance":0,"accounttype":null,"branch":null}])

    React.useEffect(() => {
        axios.get("http://localhost:8084/customers").then((response) => {
            setcustomer(response.data);
            
        });
        
    }, []);


// interface IState {
//     response: any[];
// }

// export default class Addcustomer extends React.Component<RouteComponentProps, IState> {
//     constructor(props: RouteComponentProps) {
//         super(props);
//         this.state = { response: [] }
//     }

//     public componentDidMount(): void {
//         axios.get(`http://localhost:8084/customers`).then(response => {
//             this.setState({ response: response.data })
//         })
//     }
        const deletecustomer = (id: number) =>{
        axios
        .delete(`http://localhost:8084/customers/delete/${id}`)
        .then((response) => { 
            alert("post deleted")
            console.log(response.data)

            
        
        
        })
    }


//     public deleteCustomer(id: number) {
//         axios.delete(`http://localhost:8084/customers/${id}`).then(data => {
//             const index = this.state.response.findIndex(customer => customer.id === id);
//             this.state.response.splice(index, 1);
//             this.props.history.push('/');
//         })
//   }

//     public render() {
//         const response = this.state.response;
       return (
            <div className='ads'>
                <div className='hss'>
                <nav>
                <ul>
                    <li>
                    <Link to={'/Homej'}> Home </Link>
                    </li>
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
                    <Link to={'/Login'}><button className="btn btn-sm btn">Logout</button></Link>
                   
                </ul>
                </nav>

                <div className="container">
                    <div className="row">
                        <table className="table table-bordered">
                            <thead className="thead-light">
                                <tr>
                                    <th scope="col">Account No</th>
                                    <th scope="col">customer Name</th>
                                    <th scope="col">branch</th>
                                    <th scope="col">balance</th>
                                    <th scope="col">opening date</th>
                                    <th scope="col">account type</th>
                                    <th scope="col">status</th>
                                    <th scope="col">Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {customer && customer.map((customer) =>
                                    <tr key={customer.id}>
                                        <td>{customer.id}</td>
                                        <td>{customer.name}</td>
                                        <td>{customer.branch}</td>
                                        <td>{customer.openingBalance}</td>
                                        <td>{customer.openingDate}</td>
                                        <td>{customer.accounttype}</td>
                                        <td>{customer.status?'active':'inactive'}</td>
                                        
                                        <td>
                                            <div className="d-flex justify-content-between align-items-center">
                                                <div className="btn-group" style={{ marginBottom: "20px" }}>
                                                    
                                                    {<Link to={'/Homej'}><button className="btn btn-sm btn-danger" onClick={()=>deletecustomer(customer.id)}>Delete Customer</button></Link> }
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

