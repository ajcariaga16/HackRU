import React from "react"
import Loading from './loading'

class Request extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      fullness: '', //describes how full they were
      strength: '', //describes stomach strength
      weight: '', //describes weight
      recommendation: 0,
      loading: false,
      called: false,
    }
    this.handleTakeInput = this.handleTakeInput.bind(this)
    this.updateFullnessInput = this.updateFullnessInput.bind(this)
    this.updateStrengthInput = this.updateStrengthInput.bind(this)
    this.updateWeightInput = this.updateWeightInput.bind(this)

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
      fullness: 0,
      strength: 0,
      weight: 0,
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
  render() {
    return(

      <div>
        <h3>
          Get your Drinking Recommendation
        </h3>
      {this.state.called === true
        ? <div>
            <ul>
              <li>
                {this.state.fullness}
              </li>
              <li>
                {this.state.strength}
              </li>
              <li>
                {this.state.weight}
              </li>
              <li>
                {this.state.recommendation}
              </li>
            </ul>
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
              <button onClick={this.handleTakeInput}>Submit</button>
            </div>}
            </div>
          )
  }

}

export default Request
