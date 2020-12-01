//
//  MainViewModel.swift
//  iosApp
//
//  Created by Marco Gomiero on 01/12/2020.
//  Copyright © 2020 orgName. All rights reserved.
//

import Foundation
import shared
import Alamofire

class MainViewModel: ObservableObject {
    
    @Published var activityName: String = "Bored?"
    @Published var showLoading: Bool = false
        
    func getActivity() {
        
        self.showLoading = true
        
        AF.request("https://www.boredapi.com/api/activity")
            .response(responseSerializer: CustomSerializer<Activity>()) { response in
                if let activity = response.value {
                    DispatchQueue.main.async {
                        self.showLoading = false
                        self.activityName = activity.activity
                    }
                }
            }
    }
}
