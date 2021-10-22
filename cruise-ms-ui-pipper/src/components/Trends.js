import React, { Component } from 'react'
import Trend from './Trend'

export class Trends extends Component {

    constructor(props) {
        super(props)
    
        this.state = {
            trends:[
                {
                    id: 1,
                    category:"Technology",
                    hastag: "#HuaweiWatch3series",
                    tweets: "4,127 Tweets"
                },
                {
                    id: 2,
                    category:"Animal",
                    hastag: "#pitbull",
                    tweets: "2,217 Tweets"
                },
                {
                    id: 3,
                    category:"Politics",
                    hastag: "#CR17",
                    tweets: "2,000 Tweets"
                },
                {
                    id: 4,
                    category:"Politics",
                    hastag: "#Zuma",
                    tweets: "1,927 Tweets"
                },
                {
                    id: 5,
                    category:"Entertainment",
                    hastag: "#Jcole",
                    tweets: "1,827 Tweets"
                },
                {
                    id: 6,
                    category:"Entertainment",
                    hastag: "#B.I.G",
                    tweets: "1,727 Tweets"
                },
                {
                    id: 7,
                    category:"Entertainment",
                    hastag: "#Amaroto",
                    tweets: "1,627 Tweets"
                },
                {
                    id: 8,
                    category:"Podcast",
                    hastag: "#Macg",
                    tweets: "1,527 Tweets"
                },
                {
                    id: 9,
                    category:"Technology",
                    hastag: "#HuaweiWatch3series",
                    tweets: "4,127 Tweets"
                },
                {
                    id: 10,
                    category:"Technology",
                    hastag: "#HuaweiWatch3series",
                    tweets: "4,127 Tweets"
                },
                {
                    id: 11,
                    category:"Technology",
                    hastag: "#HuaweiWatch3series",
                    tweets: "4,127 Tweets"
                }
            ]        
        }
    }
    

    render() {
        return (
            <div className="trends">
            {
                this.state.trends.map((value)=>(
                    <Trend
                        key={value.id}
                        category={value.category}
                        hastag={value.hastag}
                        tweets={value.tweets}
                     />
                ))
            }
            </div>
        )
    }
}

export default Trends
