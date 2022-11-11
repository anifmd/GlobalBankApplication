import * as React from 'react';
import {Link , RouteComponentProps, withRouter } from 'react-router-dom';
import axios from 'axios';

export interface IValues {
    name: string,
    city: number,
    
}

export interface IFormState {
    [key: string]: any;
    values: IValues[];
    submitSuccess: boolean;
    loading: boolean;
}

class Addbranch extends React.Component<RouteComponentProps, IFormState> {
    constructor(props: RouteComponentProps) {
        super(props);
        this.state = {
            name: '',
            city: '',
            
            values: [],
            loading: false,
            submitSuccess: false,
        }
    }

    processFormSubmission = (e: React.FormEvent<HTMLFormElement>): void => {
        e.preventDefault();
        this.setState({ loading: true });

        const formData = {
            name: this.state.last_name,
            city: this.state.email,
            
        }

        this.setState({ submitSuccess: true, values: [...this.state.values, formData], loading: false });

        axios.post(`http://localhost:8084/branches/add`, formData).then(data => [
            setTimeout(() => {
                this.props.history.push('/Displaybranch');
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
                    <h2>Add Branch page</h2>
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

                    <form id={"Addbranch-post-form"} onSubmit={this.processFormSubmission} noValidate={true} style={{borderStyle:"solid"}}>
                        

                        <div className="form-group col-md-12">
                            <label htmlFor="last_name"> branch name</label>
                            <input type="text" id="last_name" onChange={(e) => this.handleInputChanges(e)} name="last_name" className="form-control" placeholder="Enter customer's branch name" />
                        </div>

                        <div className="form-group col-md-12">
                            <label htmlFor="email"> Branch city </label>
                            <input type="email" id="email" onChange={(e) => this.handleInputChanges(e)} name="email" className="form-control" placeholder="Enter Branch city" />
                        </div>

  


                      
                        <div className="form-group col-md-4 pull-right">
                            <button className="btn btn-success" type="submit">
                                Submit
              </button>
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

export default withRouter(Addbranch)
