import React from "react"
import Loading from './loading'

class Log extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      fullness: '', //describes how full they were
      strength: '', //describes stomach strength
      weight: '', //describes weight
      feeling: '',
      numDrinks: '',
      loading: false,
      called: false,
    }
    this.handleTakeInput = this.handleTakeInput.bind(this)
    this.updateFullnessInput = this.updateFullnessInput.bind(this)
    this.updateStrengthInput = this.updateStrengthInput.bind(this)
    this.updateWeightInput = this.updateWeightInput.bind(this)
    this.resetInput = this.resetInput.bind(this)

  }

  /** HANDLE SENDING TO DATABASE AND RESETING FIELDS */
  handleTakeInput(fullness, strength, weight) {
    this.setState({
      loading: true
    })
    /* when the promise is fulfilled and data is obtained (.then), setState.
      componentDidUpdate will trigger again, and render will trigger.
    */
    this.setState({
      loading: false,
      fullness: '',
      strength: '',
      weight: '',
      numDrinks: '',
      feeling: '',
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
  updateFeelingInput(e) {
    const value = e.target.value
    this.setState({
      feeling: value
    })
  }
  updateNumDrinksInput(e) {
    const value = e.target.value
    this.setState({
      numDrinks: value
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
            Thank you for logging your experience!
            <button onClick={this.resetInput}>Log another experience</button>
        </div>
        : this.state.loading === true
          ? <Loading />
          : <div>
              <h4>
                Log how you felt last time to help others!
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
                placeholder='How did you feel?'
                value ={this.state.feeling}
                onChange={this.updateFeelingInput}
              />
              <br/>
              <input
                type ='text'
                placeholder='Number of drinks'
                value ={this.state.numDrinks}
                onChange={this.updateNumDrinksInput}
              />
              <br/>
              <button onClick={this.handleTakeInput}>Submit</button>
            </div>}
            </div>
          )
  }

}

export default Log
