import * as React from 'react';
import { render } from 'react-dom';
import { Link, RouteComponentProps } from 'react-router-dom';
import axios from 'axios';
import "./styles/Homej.css"

interface IState {
    customers: any[];
}

export default class Home extends React.Component<RouteComponentProps, IState> {
    constructor(props: RouteComponentProps) {
        super(props);
        this.state = { customers: [] }
    }

    //public componentDidMount(): void {
       // axios.get(`http://localhost:8084/customers`).then(data => {
         //   this.setState({ customers: data.data })
        //})
    //}

    //public deleteCustomer(id: number) {
      //  axios.delete(`http://localhost:8084/customers/${id}`).then(data => {
        //    const index = this.state.customers.findIndex(customer => customer.id === id);
          //  this.state.customers.splice(index, 1);
            //this.props.history.push('/');
        //})
    //}

    render() {
        const customers = this.state.customers;
        return (
            <div className='homecss'>
                
                    <div className='hss'>
                        <nav>
                            <ul>
                                <li>
                                <Link to={'/Addcustomer'}>  Add Customer </Link>
                                </li>
                                
                                <li>
                                <Link to={'/displaycustomer'}> Display Customers</Link>
                                </li>
                                <li>
                                <Link to={'/Addbranch'}> Add Branch</Link>
                                </li>
                                <li>
                                <Link to={'/Displaybranch'}>  Display Branch Details </Link>
                                </li>
                                
                                <Link to={'/Login'}><button className="btn btn-sm btn">Logout</button></Link>
                               
                            </ul>
                        </nav>
                    
                    </div>
                    {customers.length === 0 && (
                        <div className="text-center">
                            <h2>
                                Welcome to Homepage
                            </h2>
                        </div>
                    )}

                
            </div>
        )
    }
}
