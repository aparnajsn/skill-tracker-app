import logo from './images/logo/logo192.png';
import './App.css';

import Header from './components/Header/index'
import Search from './components/Search/index'
import SearchResult from './components/SearchResult';

function App() {
  return (
    <div className="App">
      <Header />
      <Search />
      <SearchResult />
    </div>
  );
}

export default App;
