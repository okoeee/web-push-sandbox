import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {SwPush} from '@angular/service-worker';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'web-push-sandbox-app';
  private publicKey = 'BAU8tTZozk7GwhJv3xm0b0wrEiW8_Bx5hDLnRYc1epSwpPei4hecZW4gvYKxj5Y7KoD6Wpjmo78Xjzei1n0bBbs'

  constructor(
    private http: HttpClient,
    private swPush: SwPush
  ) {}

  ngOnInit(): void {
    this.subscribeToPush()
    this.swPush.messages.subscribe(message => {
      console.log('Push message: ', message)
    })
  }

  subscribeToPush() {
    if(!this.swPush.isEnabled) {
      console.warn('Push notifications are not enabled')
      return
    }

    this.swPush
      .requestSubscription({
        serverPublicKey: this.publicKey
      })
      .then(subscription =>{
        console.log('subscription: ', subscription.toJSON())
      })
  }

}
