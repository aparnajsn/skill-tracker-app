

import React from 'react';
import Button from 'react-bootstrap/Button';
import InputGroup from 'react-bootstrap/InputGroup';
import FormControl from 'react-bootstrap/FormControl';
import FormLabel from 'react-bootstrap/FormLabel';
import Form from 'react-bootstrap/Form';


class Search extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
         
        };
    
        this.handleName = this.handleName.bind(this);
      }
    
      handleName(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;

        console.log(`name : ${name} value : ${value}`)

        this.setState({
          [name]: value
        });
      }



render (){

return(
        <form>
            <>
            
            <div className="search-area">
            <FormLabel>SEARCH VALUE</FormLabel>
            <InputGroup className="mb-3">
                <FormControl
                placeholder="Name"
                aria-label="Name"
                aria-describedby="basic-addon2"
                />
                <Button variant="outline-secondary" id="button-addon2">
                NAME
                </Button>
            </InputGroup>

            <InputGroup className="mb-3">
                <FormControl
                placeholder="Associate ID"
                aria-label="Associcate ID"
                aria-describedby="basic-addon2"
                />
                <Button variant="outline-secondary" id="button-addon2">
                ASSOCIATE ID
                </Button>
            </InputGroup>

            <InputGroup className="mb-3">
                <Form.Select aria-label="Default select example">
                    <option>Open this select menu</option>
                    <option value="1">One</option>
                    <option value="2">Two</option>
                    <option value="3">Three</option>
                </Form.Select>
                <Button variant="outline-secondary" id="button-addon2">
                SKILL
                </Button>
            </InputGroup>

            </div>
            </>
        </form>
)};

}

export default Search