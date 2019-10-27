import React, {useState, useEffect} from "react";
import axios from "axios";
import GuestListItem from "./GuestListItem";
import {Table} from "react-bootstrap";

const GuestsList = () => {

    const cardStyle = {margin: '20px auto', width: '40rem'};

    const [guests, setGuests] = useState([]);

    useEffect(() => {
        axios.get("/api/all").then(response => setGuests(response.data));
    }, [])

    return (
        <>
            <h1 style={cardStyle}>Svatebčané</h1>
            <Table striped bordered hover size="sm" style={cardStyle}>
                <thead>
                <tr>
                    <th>Jméno</th>
                    <th>Příjmení</th>
                    <th>Přijaté pozvání</th>
                </tr>   
                </thead>
                <tbody>
                {guests.map(guest => {
                    return (<GuestListItem guest={guest}/>)
                })}
                </tbody>
            </Table>
        </>

    );
}

export default GuestsList;