import React from "react"

const GuestListItem = props => {

    return (
        <tr>
            <td>{props.guest.name}</td>
            <td>{props.guest.surname}</td>
            <td>{props.guest.participationConfirmed ? "Ano" : "Ne"}</td>
        </tr> 
    )

}

export default GuestListItem;