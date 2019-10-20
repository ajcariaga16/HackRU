import React from "react"
import Loading from './loading'

window.API = {
      fetchNumDrinks(language = 'all') {
        const encodedURI = encodeURI(`https://api.github.com/search/repositories?q=stars:>1+language:${language}&sort=stars&order=desc&type=Repositories`)

        return fetch(encodedURI)
          .then((data) => data.json())
          .then((repos) => repos.items)
          .catch((error) => {
            console.warn(error)
            return null
          });
      }
    }


class Request extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      fullness: '', //describes how full they were
      strength: '', //describes stomach strength
      weight: '', //describes weight
      gender: '',
      recommendation: 0,
      loading: false,
      called: false,
    }
    this.handleTakeInput = this.handleTakeInput.bind(this)
    this.updateFullnessInput = this.updateFullnessInput.bind(this)
    this.updateStrengthInput = this.updateStrengthInput.bind(this)
    this.updateWeightInput = this.updateWeightInput.bind(this)
    this.resetInput = this.resetInput.bind(this)
    this.updateGenderInput = this.updateGenderInput.bind(this)

  }

  /** HANDLE SENDING TO DATABASE AND RESETING FIELDS */
  handleTakeInput(fullness, strength, weight) {
    this.setState({
      loading: true
    })
    /* when the promise is fulfilled and data is obtained (.then), setState.
      componentDidUpdate will trigger again, and render will trigger.
    */

    encodeURIComponent(JSON.stringify([this.state.fullness,
      this.state.weight, this.state.strength,
      this.state.numDrinks, this.state.gender]))


    this.setState({
      loading: false,
      fullness: '',
      strength: '',
      weight: '',
      gender: '',
      recommendation: 5,
      called: true,
    })
  }

  /** UPDATE STATE AFTER INPUT IN INPUT FIELDS */

  updateFullnessInput(e) {
    const value = e.target.value
    this.setState({
      fullness: value
    })
  }
  updateStrengthInput(e) {
    const value = e.target.value
    this.setState({
      strength: value
    })
  }
  updateWeightInput(e) {
    const value = e.target.value
    this.setState({
      weight: value
    })
  }
  updateGenderInput(e) {
    const value = e.target.value
    this.setState({
      gender: value
    })
  }
  resetInput() {
    this.setState({
      called: false,
    })
  }
  render() {
    return(

      <div>
      {this.state.called === true
        ? <div>
            You can take an estimated {this.state.recommendation} drinks before
            throwing up.
            <button onClick={this.resetInput}>Try another input</button>
        </div>
        : this.state.loading === true
          ? <Loading />
          : <div>
              <h4>
                Request Drinking Recommendation:
              </h4>
              <input
                type ='text'
                placeholder='Fullness'
                value ={this.state.fullness}
                onChange={this.updateFullnessInput}
              />
              <br/>
              <input
                type ='text'
                placeholder='Stomach Strength'
                value ={this.state.strength}
                onChange={this.updateStrengthInput}
              />
              <br/>
              <input
                type ='text'
                placeholder='Weight'
                value ={this.state.weight}
                onChange={this.updateWeightInput}
              />
              <br/>
              <input
                type ='text'
                placeholder='Gender (M or F)'
                value ={this.state.gender}
                onChange={this.updateGenderInput}
              />
              <br/>
              <button onClick={this.handleTakeInput}>Submit</button>
            </div>}
            </div>
          )
  }

}

export default Request
