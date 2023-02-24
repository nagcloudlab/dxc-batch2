import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-voting-item',
  templateUrl: './voting-item.component.html',
  styleUrls: ['./voting-item.component.css']
})
export class VotingItemComponent {


  @Input()
  value = "";

  // state
  likes = 0
  dislikes = 0

  @Output()
  vote = new EventEmitter()


  handleLikeEvent() {
    this.likes++;
    this.vote.emit({ name: this.value, likes: this.likes, dislikes: this.dislikes })
  }
  handleDislikeEvent() {
    this.dislikes++;
    this.vote.emit({ name: this.value, likes: this.likes, dislikes: this.dislikes })
  }



}
