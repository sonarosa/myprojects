import React from "react";
import "./index.css";
import home from "./routes/home"
import about from "./routes/about"
import contact from "./routes/contact"
import project from "./routes/project"
import { Route, Routes } from "react-router-dom";
function App() {
  return (
    <>
      <Routes>
        <Route path="/" element={<home/>}/>
        <Route path="/project" element={<project/>}/>
        <Route path="/about" element={<about/>}/>
        <Route path="/contact" element={<contact/>}/>
      </Routes>
    </>
  );
}

export default App;
