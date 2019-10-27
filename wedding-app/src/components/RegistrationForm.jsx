import React, { useEffect, useState, Fragment } from "react";
import {Redirect} from "react-router-dom";
import axios from "axios";
import {ListGroup, ListGroupItem, Button, ButtonToolbar} from "react-bootstrap";
import "../index.css";

const RegistrationForm = ({match}) => {

    const cardStyle = {margin: '20px auto', minWidth: '2rem', maxWidth: '20rem', textAlign: 'center', color: 'black'};

    const {params: {code}} = match;
    const [guests, setGuests] = useState([]);
    const [redirect, setRedirect] = useState(false);

    useEffect(() => {
        axios.get("/api/registration/" + code).then(response => setGuests(response.data));
    }, [code]);

    const handleConfirmParticipation = () => {
        axios.post(`/api/registration/${code}?participationAccepted=${true}`).then(setRedirect(true));
    };

    const handleDeclineParticipation = () => {
        axios.post(`/api/registration/${code}?participationAccepted=${false}`).then(setRedirect(true));
    };

    const redirectToLandingPage = () => {
        return <Redirect to="/"/>
    };

    return (
        <Fragment>
            {redirect ? redirectToLandingPage() : ""}
            <h2 style={cardStyle}>Svatebčané</h2>
            <hr style={cardStyle} />
            <ListGroup style={cardStyle}>
                {guests.map(guest => {
                    return (<ListGroupItem className="container">{guest.name + " " + guest.surname}</ListGroupItem>)
                })}
            </ListGroup>
            <br/>
            <p style={cardStyle}>Na obřad a hostinu... </p>
            <ButtonToolbar style={cardStyle}>
                <Button size="lg" block className="button nokButton" onClick={handleDeclineParticipation}>{guests.length > 1 ? "Nedorazíme :(" : "Nedorazím :("}</Button>
                <Button size="lg" block className="button okButton" onClick={handleConfirmParticipation}>{guests.length > 1 ? "Jasně že dorazíme!" : "Jasně že dorazím!"}</Button>
            </ButtonToolbar>
            <hr style={cardStyle} />
        </Fragment>

    );

};

export default RegistrationForm;