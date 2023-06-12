import React from 'react';
import Data from './Data';
import Main_menu from './Main_menu';
import "./css/style.css"


// function Index() {
  
//   return(
//      <h1>Strona główna</h1>,
//   // <Data />
//   <Main_menu/>
  
//   );
// }
function Index({ loggedIn, handleLogout }) {
  return (
    <>

  <Main_menu/>
    </>
  );
}

export default Index;