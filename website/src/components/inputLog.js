import React from 'react'

class Log extends React.component {
  constructor(props) {
    super (props)

    this.state = {
      fullness: 0, //describes how full they were
      strength: 0, //describes stomach strength
      weight: 0, //describes weight
      feeling: 0, //how they felt
    }
  }
  render() {
    return (
      <div>
        This is the log
      </div>
    )
  }
}

export default Log
