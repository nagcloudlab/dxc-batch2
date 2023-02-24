import { Component } from '@angular/core';

@Component({
  selector: 'app-voting-box',
  templateUrl: './voting-box.component.html',
  styleUrls: ['./voting-box.component.css']
})
export class VotingBoxComponent {

  items = [
    "java",
    "spring",
    "api"
  ]
  votes: Array<any> = []

  handleVote(vote: any) {
    let { name, likes, dislikes } = vote;
    const voteLine = this.votes.find(line => line.name == name);
    if (voteLine) {
      voteLine.likes = likes;
      voteLine.dislikes = dislikes;
    } else {
      this.votes.push({ name, likes, dislikes });
    }
  }



}
