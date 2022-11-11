import * as React from 'react';
import {Link , RouteComponentProps, withRouter } from 'react-router-dom';
import axios from 'axios';

export interface IValues {
    customer: number,
            branch: number,
            openingBalance: string,
            openingDate: string,
            accountType:string,
            status:boolean
            
    
}

export interface IFormState {
    [key: string]: any;
    values: IValues[];
    submitSuccess: boolean;
    loading: boolean;
}

class Addcustomer extends React.Component<RouteComponentProps, IFormState> {
    constructor(props: RouteComponentProps) {
        super(props);
        this.state = {
            first_name: '',
            last_name: '',
            email: '',
            phone: '',
            address: '',
            type:'',
            status:'',
            
            values: [],
            loading: false,
            submitSuccess: false,
        }
    }


    processFormSubmission = (e: any): void => {
        e.preventDefault();
        this.setState({ loading: true });
        console.log("hello");
        const formData = {
            customer: this.state.last_name,
            branch: this.state.email,
            openingBalance: this.state.phone,
            openingDate: this.state.address,
            accountType:this.state.type,
            status:this.state.status
            
        }

        this.setState({ submitSuccess: true, values: [...this.state.values, formData], loading: false});
    
        axios.post(`http://localhost:8084/accounts/add`, formData).then(data => [
            setTimeout(() => {
                console.log(formData);
                this.props.history.push('/displaycustomer');
            }, 1500)
        ]);
    }

    handleInputChanges = (e: React.FormEvent<HTMLInputElement>) => {
        e.preventDefault();
        this.setState({
            [e.currentTarget.name]: e.currentTarget.value,
        })
    }

     render() {
        const { submitSuccess, loading } = this.state;
        return (
            <div className='ads'>
                <div className='hss'>
                <nav>
                <ul>
                
                    <li>
                    <Link to={'/Homej'}>  Home </Link>
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


                
                <div className={"col-md-12 form-wrapper"}>
                    <h2>Customer account opening page</h2>
                    {!submitSuccess && (
                        <div className="alert alert-info" role="alert">
                            Fill the form below to add customer
                    </div>
                    )}

                    {submitSuccess && (
                        <div className="alert alert-info" role="alert">
                            The form was successfully submitted!
                            </div>
                    )}

                    <form id={"create-post-form"} onSubmit={this.processFormSubmission} noValidate={true} style={{borderStyle:'solid'}}>
                        <div className="form-group col-md-12">
                            <p>Account Number </p>
                            <input type="text" id="first_name" onChange={(e) => this.handleInputChanges(e)} name="first_name" className="form-control" placeholder="Enter customer's Account No." />
                        </div>

                        <div className="form-group col-md-12">
                            <label htmlFor="last_name"> Customer Id</label>
                            <input type="text" id="last_name" onChange={(e) => this.handleInputChanges(e)} name="last_name" className="form-control" placeholder="Enter customer id" />
                        </div>

                        <div className="form-group col-md-12">
                            <label htmlFor="email"> Branch Id </label>
                            <input type="email" id="email" onChange={(e) => this.handleInputChanges(e)} name="email" className="form-control" placeholder="Enter Branch id" />
                        </div>

                        <div className="form-group col-md-12">
                            <label htmlFor="phone"> Balance </label>
                            <input type="text" id="phone" onChange={(e) => this.handleInputChanges(e)} name="phone" className="form-control" placeholder="Enter balance" />
                        </div>

                        <div className="form-group col-md-12">
                            <label htmlFor="address"> Opening Date </label>
                            <input type="text" id="address" onChange={(e) => this.handleInputChanges(e)} name="address" className="form-control" placeholder="Enter opening date" />
                        </div>
                        <div className="form-group col-md-12">
                        <label htmlFor="status"> Status</label>
                            <input type="text" id="status" onChange={(e) => this.handleInputChanges(e)} name="status" className="form-control" placeholder="Enter status" />
                        </div>
                        <div className="form-group col-md-12">
                        <label htmlFor="type"> type</label>
                            <input type="text" id="type" onChange={(e) => this.handleInputChanges(e)} name="type" className="form-control" placeholder="Enter type" />
                        </div>

                        <div className="form-group col-md-4 pull-center">
                            <Link to ={'/displaycustomer'} ><button onClick={(e)=>this.processFormSubmission(e)} className="btn btn-success" type="submit">
                                Create Customer 
              </button></Link>
                            {loading &&
                                <span className="fa fa-circle-o-notch fa-spin" />
                            }
                        </div>
                    </form>
                </div>
                </div>
            </div>
            
        )
    }
}

export default withRouter(Addcustomer)
